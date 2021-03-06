package co.getair.meerkat.video.broadcast.googlecode.mp4parser.h264.model;

import co.getair.meerkat.video.broadcast.googlecode.mp4parser.h264.read.CAVLCReader;
import co.getair.meerkat.video.broadcast.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SeqParameterSet extends BitstreamElement
{
  public int bit_depth_chroma_minus8;
  public int bit_depth_luma_minus8;
  public ChromaFormat chroma_format_idc;
  public boolean constraint_set_0_flag;
  public boolean constraint_set_1_flag;
  public boolean constraint_set_2_flag;
  public boolean constraint_set_3_flag;
  public boolean constraint_set_4_flag;
  public boolean constraint_set_5_flag;
  public boolean delta_pic_order_always_zero_flag;
  public boolean direct_8x8_inference_flag;
  public boolean entropy_coding_mode_flag;
  public boolean field_pic_flag;
  public int frame_crop_bottom_offset;
  public int frame_crop_left_offset;
  public int frame_crop_right_offset;
  public int frame_crop_top_offset;
  public boolean frame_cropping_flag;
  public boolean frame_mbs_only_flag;
  public boolean gaps_in_frame_num_value_allowed_flag;
  public int level_idc;
  public int log2_max_frame_num_minus4;
  public int log2_max_pic_order_cnt_lsb_minus4;
  public boolean mb_adaptive_frame_field_flag;
  public int num_ref_frames;
  public int num_ref_frames_in_pic_order_cnt_cycle;
  public int[] offsetForRefFrame;
  public int offset_for_non_ref_pic;
  public int offset_for_top_to_bottom_field;
  public int pic_height_in_map_units_minus1;
  public int pic_order_cnt_type;
  public int pic_width_in_mbs_minus1;
  public int profile_idc;
  public boolean qpprime_y_zero_transform_bypass_flag;
  public long reserved_zero_2bits;
  public boolean residual_color_transform_flag;
  public ScalingMatrix scalingMatrix;
  public int seq_parameter_set_id;
  public VUIParameters vuiParams;
  public int weighted_bipred_idc;
  public boolean weighted_pred_flag;

  private static VUIParameters ReadVUIParameters(CAVLCReader paramCAVLCReader)
    throws IOException
  {
    VUIParameters localVUIParameters = new VUIParameters();
    localVUIParameters.aspect_ratio_info_present_flag = paramCAVLCReader.readBool("VUI: aspect_ratio_info_present_flag");
    if (localVUIParameters.aspect_ratio_info_present_flag)
    {
      localVUIParameters.aspect_ratio = AspectRatio.fromValue((int)paramCAVLCReader.readNBit(8, "VUI: aspect_ratio"));
      if (localVUIParameters.aspect_ratio == AspectRatio.Extended_SAR)
      {
        localVUIParameters.sar_width = ((int)paramCAVLCReader.readNBit(16, "VUI: sar_width"));
        localVUIParameters.sar_height = ((int)paramCAVLCReader.readNBit(16, "VUI: sar_height"));
      }
    }
    localVUIParameters.overscan_info_present_flag = paramCAVLCReader.readBool("VUI: overscan_info_present_flag");
    if (localVUIParameters.overscan_info_present_flag)
      localVUIParameters.overscan_appropriate_flag = paramCAVLCReader.readBool("VUI: overscan_appropriate_flag");
    localVUIParameters.video_signal_type_present_flag = paramCAVLCReader.readBool("VUI: video_signal_type_present_flag");
    if (localVUIParameters.video_signal_type_present_flag)
    {
      localVUIParameters.video_format = ((int)paramCAVLCReader.readNBit(3, "VUI: video_format"));
      localVUIParameters.video_full_range_flag = paramCAVLCReader.readBool("VUI: video_full_range_flag");
      localVUIParameters.colour_description_present_flag = paramCAVLCReader.readBool("VUI: colour_description_present_flag");
      if (localVUIParameters.colour_description_present_flag)
      {
        localVUIParameters.colour_primaries = ((int)paramCAVLCReader.readNBit(8, "VUI: colour_primaries"));
        localVUIParameters.transfer_characteristics = ((int)paramCAVLCReader.readNBit(8, "VUI: transfer_characteristics"));
        localVUIParameters.matrix_coefficients = ((int)paramCAVLCReader.readNBit(8, "VUI: matrix_coefficients"));
      }
    }
    localVUIParameters.chroma_loc_info_present_flag = paramCAVLCReader.readBool("VUI: chroma_loc_info_present_flag");
    if (localVUIParameters.chroma_loc_info_present_flag)
    {
      localVUIParameters.chroma_sample_loc_type_top_field = paramCAVLCReader.readUE("VUI chroma_sample_loc_type_top_field");
      localVUIParameters.chroma_sample_loc_type_bottom_field = paramCAVLCReader.readUE("VUI chroma_sample_loc_type_bottom_field");
    }
    localVUIParameters.timing_info_present_flag = paramCAVLCReader.readBool("VUI: timing_info_present_flag");
    if (localVUIParameters.timing_info_present_flag)
    {
      localVUIParameters.num_units_in_tick = ((int)paramCAVLCReader.readNBit(32, "VUI: num_units_in_tick"));
      localVUIParameters.time_scale = ((int)paramCAVLCReader.readNBit(32, "VUI: time_scale"));
      localVUIParameters.fixed_frame_rate_flag = paramCAVLCReader.readBool("VUI: fixed_frame_rate_flag");
    }
    boolean bool1 = paramCAVLCReader.readBool("VUI: nal_hrd_parameters_present_flag");
    if (bool1)
      localVUIParameters.nalHRDParams = readHRDParameters(paramCAVLCReader);
    boolean bool2 = paramCAVLCReader.readBool("VUI: vcl_hrd_parameters_present_flag");
    if (bool2)
      localVUIParameters.vclHRDParams = readHRDParameters(paramCAVLCReader);
    if ((bool1) || (bool2))
      localVUIParameters.low_delay_hrd_flag = paramCAVLCReader.readBool("VUI: low_delay_hrd_flag");
    localVUIParameters.pic_struct_present_flag = paramCAVLCReader.readBool("VUI: pic_struct_present_flag");
    if (paramCAVLCReader.readBool("VUI: bitstream_restriction_flag"))
    {
      localVUIParameters.bitstreamRestriction = new VUIParameters.BitstreamRestriction();
      localVUIParameters.bitstreamRestriction.motion_vectors_over_pic_boundaries_flag = paramCAVLCReader.readBool("VUI: motion_vectors_over_pic_boundaries_flag");
      localVUIParameters.bitstreamRestriction.max_bytes_per_pic_denom = paramCAVLCReader.readUE("VUI max_bytes_per_pic_denom");
      localVUIParameters.bitstreamRestriction.max_bits_per_mb_denom = paramCAVLCReader.readUE("VUI max_bits_per_mb_denom");
      localVUIParameters.bitstreamRestriction.log2_max_mv_length_horizontal = paramCAVLCReader.readUE("VUI log2_max_mv_length_horizontal");
      localVUIParameters.bitstreamRestriction.log2_max_mv_length_vertical = paramCAVLCReader.readUE("VUI log2_max_mv_length_vertical");
      localVUIParameters.bitstreamRestriction.num_reorder_frames = paramCAVLCReader.readUE("VUI num_reorder_frames");
      localVUIParameters.bitstreamRestriction.max_dec_frame_buffering = paramCAVLCReader.readUE("VUI max_dec_frame_buffering");
    }
    return localVUIParameters;
  }

  public static SeqParameterSet read(InputStream paramInputStream)
    throws IOException
  {
    CAVLCReader localCAVLCReader = new CAVLCReader(paramInputStream);
    SeqParameterSet localSeqParameterSet = new SeqParameterSet();
    localSeqParameterSet.profile_idc = ((int)localCAVLCReader.readNBit(8, "SPS: profile_idc"));
    localSeqParameterSet.constraint_set_0_flag = localCAVLCReader.readBool("SPS: constraint_set_0_flag");
    localSeqParameterSet.constraint_set_1_flag = localCAVLCReader.readBool("SPS: constraint_set_1_flag");
    localSeqParameterSet.constraint_set_2_flag = localCAVLCReader.readBool("SPS: constraint_set_2_flag");
    localSeqParameterSet.constraint_set_3_flag = localCAVLCReader.readBool("SPS: constraint_set_3_flag");
    localSeqParameterSet.constraint_set_4_flag = localCAVLCReader.readBool("SPS: constraint_set_4_flag");
    localSeqParameterSet.constraint_set_5_flag = localCAVLCReader.readBool("SPS: constraint_set_5_flag");
    localSeqParameterSet.reserved_zero_2bits = localCAVLCReader.readNBit(2, "SPS: reserved_zero_2bits");
    localSeqParameterSet.level_idc = ((int)localCAVLCReader.readNBit(8, "SPS: level_idc"));
    localSeqParameterSet.seq_parameter_set_id = localCAVLCReader.readUE("SPS: seq_parameter_set_id");
    if ((localSeqParameterSet.profile_idc == 100) || (localSeqParameterSet.profile_idc == 110) || (localSeqParameterSet.profile_idc == 122) || (localSeqParameterSet.profile_idc == 144))
    {
      localSeqParameterSet.chroma_format_idc = ChromaFormat.fromId(localCAVLCReader.readUE("SPS: chroma_format_idc"));
      if (localSeqParameterSet.chroma_format_idc == ChromaFormat.YUV_444)
        localSeqParameterSet.residual_color_transform_flag = localCAVLCReader.readBool("SPS: residual_color_transform_flag");
      localSeqParameterSet.bit_depth_luma_minus8 = localCAVLCReader.readUE("SPS: bit_depth_luma_minus8");
      localSeqParameterSet.bit_depth_chroma_minus8 = localCAVLCReader.readUE("SPS: bit_depth_chroma_minus8");
      localSeqParameterSet.qpprime_y_zero_transform_bypass_flag = localCAVLCReader.readBool("SPS: qpprime_y_zero_transform_bypass_flag");
      if (localCAVLCReader.readBool("SPS: seq_scaling_matrix_present_lag"))
        readScalingListMatrix(localCAVLCReader, localSeqParameterSet);
      localSeqParameterSet.log2_max_frame_num_minus4 = localCAVLCReader.readUE("SPS: log2_max_frame_num_minus4");
      localSeqParameterSet.pic_order_cnt_type = localCAVLCReader.readUE("SPS: pic_order_cnt_type");
      if (localSeqParameterSet.pic_order_cnt_type != 0)
        break label474;
      localSeqParameterSet.log2_max_pic_order_cnt_lsb_minus4 = localCAVLCReader.readUE("SPS: log2_max_pic_order_cnt_lsb_minus4");
    }
    while (true)
    {
      localSeqParameterSet.num_ref_frames = localCAVLCReader.readUE("SPS: num_ref_frames");
      localSeqParameterSet.gaps_in_frame_num_value_allowed_flag = localCAVLCReader.readBool("SPS: gaps_in_frame_num_value_allowed_flag");
      localSeqParameterSet.pic_width_in_mbs_minus1 = localCAVLCReader.readUE("SPS: pic_width_in_mbs_minus1");
      localSeqParameterSet.pic_height_in_map_units_minus1 = localCAVLCReader.readUE("SPS: pic_height_in_map_units_minus1");
      localSeqParameterSet.frame_mbs_only_flag = localCAVLCReader.readBool("SPS: frame_mbs_only_flag");
      if (!localSeqParameterSet.frame_mbs_only_flag)
        localSeqParameterSet.mb_adaptive_frame_field_flag = localCAVLCReader.readBool("SPS: mb_adaptive_frame_field_flag");
      localSeqParameterSet.direct_8x8_inference_flag = localCAVLCReader.readBool("SPS: direct_8x8_inference_flag");
      localSeqParameterSet.frame_cropping_flag = localCAVLCReader.readBool("SPS: frame_cropping_flag");
      if (localSeqParameterSet.frame_cropping_flag)
      {
        localSeqParameterSet.frame_crop_left_offset = localCAVLCReader.readUE("SPS: frame_crop_left_offset");
        localSeqParameterSet.frame_crop_right_offset = localCAVLCReader.readUE("SPS: frame_crop_right_offset");
        localSeqParameterSet.frame_crop_top_offset = localCAVLCReader.readUE("SPS: frame_crop_top_offset");
        localSeqParameterSet.frame_crop_bottom_offset = localCAVLCReader.readUE("SPS: frame_crop_bottom_offset");
      }
      if (localCAVLCReader.readBool("SPS: vui_parameters_present_flag"))
        localSeqParameterSet.vuiParams = ReadVUIParameters(localCAVLCReader);
      localCAVLCReader.readTrailingBits();
      return localSeqParameterSet;
      localSeqParameterSet.chroma_format_idc = ChromaFormat.YUV_420;
      break;
      label474: if (localSeqParameterSet.pic_order_cnt_type == 1)
      {
        localSeqParameterSet.delta_pic_order_always_zero_flag = localCAVLCReader.readBool("SPS: delta_pic_order_always_zero_flag");
        localSeqParameterSet.offset_for_non_ref_pic = localCAVLCReader.readSE("SPS: offset_for_non_ref_pic");
        localSeqParameterSet.offset_for_top_to_bottom_field = localCAVLCReader.readSE("SPS: offset_for_top_to_bottom_field");
        localSeqParameterSet.num_ref_frames_in_pic_order_cnt_cycle = localCAVLCReader.readUE("SPS: num_ref_frames_in_pic_order_cnt_cycle");
        localSeqParameterSet.offsetForRefFrame = new int[localSeqParameterSet.num_ref_frames_in_pic_order_cnt_cycle];
        for (int i = 0; i < localSeqParameterSet.num_ref_frames_in_pic_order_cnt_cycle; i++)
          localSeqParameterSet.offsetForRefFrame[i] = localCAVLCReader.readSE("SPS: offsetForRefFrame [" + i + "]");
      }
    }
  }

  private static HRDParameters readHRDParameters(CAVLCReader paramCAVLCReader)
    throws IOException
  {
    HRDParameters localHRDParameters = new HRDParameters();
    localHRDParameters.cpb_cnt_minus1 = paramCAVLCReader.readUE("SPS: cpb_cnt_minus1");
    localHRDParameters.bit_rate_scale = ((int)paramCAVLCReader.readNBit(4, "HRD: bit_rate_scale"));
    localHRDParameters.cpb_size_scale = ((int)paramCAVLCReader.readNBit(4, "HRD: cpb_size_scale"));
    localHRDParameters.bit_rate_value_minus1 = new int[1 + localHRDParameters.cpb_cnt_minus1];
    localHRDParameters.cpb_size_value_minus1 = new int[1 + localHRDParameters.cpb_cnt_minus1];
    localHRDParameters.cbr_flag = new boolean[1 + localHRDParameters.cpb_cnt_minus1];
    for (int i = 0; i <= localHRDParameters.cpb_cnt_minus1; i++)
    {
      localHRDParameters.bit_rate_value_minus1[i] = paramCAVLCReader.readUE("HRD: bit_rate_value_minus1");
      localHRDParameters.cpb_size_value_minus1[i] = paramCAVLCReader.readUE("HRD: cpb_size_value_minus1");
      localHRDParameters.cbr_flag[i] = paramCAVLCReader.readBool("HRD: cbr_flag");
    }
    localHRDParameters.initial_cpb_removal_delay_length_minus1 = ((int)paramCAVLCReader.readNBit(5, "HRD: initial_cpb_removal_delay_length_minus1"));
    localHRDParameters.cpb_removal_delay_length_minus1 = ((int)paramCAVLCReader.readNBit(5, "HRD: cpb_removal_delay_length_minus1"));
    localHRDParameters.dpb_output_delay_length_minus1 = ((int)paramCAVLCReader.readNBit(5, "HRD: dpb_output_delay_length_minus1"));
    localHRDParameters.time_offset_length = ((int)paramCAVLCReader.readNBit(5, "HRD: time_offset_length"));
    return localHRDParameters;
  }

  private static void readScalingListMatrix(CAVLCReader paramCAVLCReader, SeqParameterSet paramSeqParameterSet)
    throws IOException
  {
    paramSeqParameterSet.scalingMatrix = new ScalingMatrix();
    int i = 0;
    if (i < 8)
    {
      if (paramCAVLCReader.readBool("SPS: seqScalingListPresentFlag"))
      {
        paramSeqParameterSet.scalingMatrix.ScalingList4x4 = new ScalingList[8];
        paramSeqParameterSet.scalingMatrix.ScalingList8x8 = new ScalingList[8];
        if (i >= 6)
          break label80;
        paramSeqParameterSet.scalingMatrix.ScalingList4x4[i] = ScalingList.read(paramCAVLCReader, 16);
      }
      while (true)
      {
        i++;
        break;
        label80: paramSeqParameterSet.scalingMatrix.ScalingList8x8[(i - 6)] = ScalingList.read(paramCAVLCReader, 64);
      }
    }
  }

  private void writeHRDParameters(HRDParameters paramHRDParameters, CAVLCWriter paramCAVLCWriter)
    throws IOException
  {
    paramCAVLCWriter.writeUE(paramHRDParameters.cpb_cnt_minus1, "HRD: cpb_cnt_minus1");
    paramCAVLCWriter.writeNBit(paramHRDParameters.bit_rate_scale, 4, "HRD: bit_rate_scale");
    paramCAVLCWriter.writeNBit(paramHRDParameters.cpb_size_scale, 4, "HRD: cpb_size_scale");
    for (int i = 0; i <= paramHRDParameters.cpb_cnt_minus1; i++)
    {
      paramCAVLCWriter.writeUE(paramHRDParameters.bit_rate_value_minus1[i], "HRD: ");
      paramCAVLCWriter.writeUE(paramHRDParameters.cpb_size_value_minus1[i], "HRD: ");
      paramCAVLCWriter.writeBool(paramHRDParameters.cbr_flag[i], "HRD: ");
    }
    paramCAVLCWriter.writeNBit(paramHRDParameters.initial_cpb_removal_delay_length_minus1, 5, "HRD: initial_cpb_removal_delay_length_minus1");
    paramCAVLCWriter.writeNBit(paramHRDParameters.cpb_removal_delay_length_minus1, 5, "HRD: cpb_removal_delay_length_minus1");
    paramCAVLCWriter.writeNBit(paramHRDParameters.dpb_output_delay_length_minus1, 5, "HRD: dpb_output_delay_length_minus1");
    paramCAVLCWriter.writeNBit(paramHRDParameters.time_offset_length, 5, "HRD: time_offset_length");
  }

  private void writeVUIParameters(VUIParameters paramVUIParameters, CAVLCWriter paramCAVLCWriter)
    throws IOException
  {
    boolean bool1 = true;
    paramCAVLCWriter.writeBool(paramVUIParameters.aspect_ratio_info_present_flag, "VUI: aspect_ratio_info_present_flag");
    if (paramVUIParameters.aspect_ratio_info_present_flag)
    {
      paramCAVLCWriter.writeNBit(paramVUIParameters.aspect_ratio.getValue(), 8, "VUI: aspect_ratio");
      if (paramVUIParameters.aspect_ratio == AspectRatio.Extended_SAR)
      {
        paramCAVLCWriter.writeNBit(paramVUIParameters.sar_width, 16, "VUI: sar_width");
        paramCAVLCWriter.writeNBit(paramVUIParameters.sar_height, 16, "VUI: sar_height");
      }
    }
    paramCAVLCWriter.writeBool(paramVUIParameters.overscan_info_present_flag, "VUI: overscan_info_present_flag");
    if (paramVUIParameters.overscan_info_present_flag)
      paramCAVLCWriter.writeBool(paramVUIParameters.overscan_appropriate_flag, "VUI: overscan_appropriate_flag");
    paramCAVLCWriter.writeBool(paramVUIParameters.video_signal_type_present_flag, "VUI: video_signal_type_present_flag");
    if (paramVUIParameters.video_signal_type_present_flag)
    {
      paramCAVLCWriter.writeNBit(paramVUIParameters.video_format, 3, "VUI: video_format");
      paramCAVLCWriter.writeBool(paramVUIParameters.video_full_range_flag, "VUI: video_full_range_flag");
      paramCAVLCWriter.writeBool(paramVUIParameters.colour_description_present_flag, "VUI: colour_description_present_flag");
      if (paramVUIParameters.colour_description_present_flag)
      {
        paramCAVLCWriter.writeNBit(paramVUIParameters.colour_primaries, 8, "VUI: colour_primaries");
        paramCAVLCWriter.writeNBit(paramVUIParameters.transfer_characteristics, 8, "VUI: transfer_characteristics");
        paramCAVLCWriter.writeNBit(paramVUIParameters.matrix_coefficients, 8, "VUI: matrix_coefficients");
      }
    }
    paramCAVLCWriter.writeBool(paramVUIParameters.chroma_loc_info_present_flag, "VUI: chroma_loc_info_present_flag");
    if (paramVUIParameters.chroma_loc_info_present_flag)
    {
      paramCAVLCWriter.writeUE(paramVUIParameters.chroma_sample_loc_type_top_field, "VUI: chroma_sample_loc_type_top_field");
      paramCAVLCWriter.writeUE(paramVUIParameters.chroma_sample_loc_type_bottom_field, "VUI: chroma_sample_loc_type_bottom_field");
    }
    paramCAVLCWriter.writeBool(paramVUIParameters.timing_info_present_flag, "VUI: timing_info_present_flag");
    if (paramVUIParameters.timing_info_present_flag)
    {
      paramCAVLCWriter.writeNBit(paramVUIParameters.num_units_in_tick, 32, "VUI: num_units_in_tick");
      paramCAVLCWriter.writeNBit(paramVUIParameters.time_scale, 32, "VUI: time_scale");
      paramCAVLCWriter.writeBool(paramVUIParameters.fixed_frame_rate_flag, "VUI: fixed_frame_rate_flag");
    }
    boolean bool2;
    boolean bool3;
    if (paramVUIParameters.nalHRDParams != null)
    {
      bool2 = bool1;
      paramCAVLCWriter.writeBool(bool2, "VUI: ");
      if (paramVUIParameters.nalHRDParams != null)
        writeHRDParameters(paramVUIParameters.nalHRDParams, paramCAVLCWriter);
      if (paramVUIParameters.vclHRDParams == null)
        break label515;
      bool3 = bool1;
      label330: paramCAVLCWriter.writeBool(bool3, "VUI: ");
      if (paramVUIParameters.vclHRDParams != null)
        writeHRDParameters(paramVUIParameters.vclHRDParams, paramCAVLCWriter);
      if ((paramVUIParameters.nalHRDParams != null) || (paramVUIParameters.vclHRDParams != null))
        paramCAVLCWriter.writeBool(paramVUIParameters.low_delay_hrd_flag, "VUI: low_delay_hrd_flag");
      paramCAVLCWriter.writeBool(paramVUIParameters.pic_struct_present_flag, "VUI: pic_struct_present_flag");
      if (paramVUIParameters.bitstreamRestriction == null)
        break label521;
    }
    while (true)
    {
      paramCAVLCWriter.writeBool(bool1, "VUI: ");
      if (paramVUIParameters.bitstreamRestriction != null)
      {
        paramCAVLCWriter.writeBool(paramVUIParameters.bitstreamRestriction.motion_vectors_over_pic_boundaries_flag, "VUI: motion_vectors_over_pic_boundaries_flag");
        paramCAVLCWriter.writeUE(paramVUIParameters.bitstreamRestriction.max_bytes_per_pic_denom, "VUI: max_bytes_per_pic_denom");
        paramCAVLCWriter.writeUE(paramVUIParameters.bitstreamRestriction.max_bits_per_mb_denom, "VUI: max_bits_per_mb_denom");
        paramCAVLCWriter.writeUE(paramVUIParameters.bitstreamRestriction.log2_max_mv_length_horizontal, "VUI: log2_max_mv_length_horizontal");
        paramCAVLCWriter.writeUE(paramVUIParameters.bitstreamRestriction.log2_max_mv_length_vertical, "VUI: log2_max_mv_length_vertical");
        paramCAVLCWriter.writeUE(paramVUIParameters.bitstreamRestriction.num_reorder_frames, "VUI: num_reorder_frames");
        paramCAVLCWriter.writeUE(paramVUIParameters.bitstreamRestriction.max_dec_frame_buffering, "VUI: max_dec_frame_buffering");
      }
      return;
      bool2 = false;
      break;
      label515: bool3 = false;
      break label330;
      label521: bool1 = false;
    }
  }

  public String toString()
  {
    return "SeqParameterSet{ \n        pic_order_cnt_type=" + this.pic_order_cnt_type + ", \n        field_pic_flag=" + this.field_pic_flag + ", \n        delta_pic_order_always_zero_flag=" + this.delta_pic_order_always_zero_flag + ", \n        weighted_pred_flag=" + this.weighted_pred_flag + ", \n        weighted_bipred_idc=" + this.weighted_bipred_idc + ", \n        entropy_coding_mode_flag=" + this.entropy_coding_mode_flag + ", \n        mb_adaptive_frame_field_flag=" + this.mb_adaptive_frame_field_flag + ", \n        direct_8x8_inference_flag=" + this.direct_8x8_inference_flag + ", \n        chroma_format_idc=" + this.chroma_format_idc + ", \n        log2_max_frame_num_minus4=" + this.log2_max_frame_num_minus4 + ", \n        log2_max_pic_order_cnt_lsb_minus4=" + this.log2_max_pic_order_cnt_lsb_minus4 + ", \n        pic_height_in_map_units_minus1=" + this.pic_height_in_map_units_minus1 + ", \n        pic_width_in_mbs_minus1=" + this.pic_width_in_mbs_minus1 + ", \n        bit_depth_luma_minus8=" + this.bit_depth_luma_minus8 + ", \n        bit_depth_chroma_minus8=" + this.bit_depth_chroma_minus8 + ", \n        qpprime_y_zero_transform_bypass_flag=" + this.qpprime_y_zero_transform_bypass_flag + ", \n        profile_idc=" + this.profile_idc + ", \n        constraint_set_0_flag=" + this.constraint_set_0_flag + ", \n        constraint_set_1_flag=" + this.constraint_set_1_flag + ", \n        constraint_set_2_flag=" + this.constraint_set_2_flag + ", \n        constraint_set_3_flag=" + this.constraint_set_3_flag + ", \n        constraint_set_4_flag=" + this.constraint_set_4_flag + ", \n        constraint_set_5_flag=" + this.constraint_set_5_flag + ", \n        level_idc=" + this.level_idc + ", \n        seq_parameter_set_id=" + this.seq_parameter_set_id + ", \n        residual_color_transform_flag=" + this.residual_color_transform_flag + ", \n        offset_for_non_ref_pic=" + this.offset_for_non_ref_pic + ", \n        offset_for_top_to_bottom_field=" + this.offset_for_top_to_bottom_field + ", \n        num_ref_frames=" + this.num_ref_frames + ", \n        gaps_in_frame_num_value_allowed_flag=" + this.gaps_in_frame_num_value_allowed_flag + ", \n        frame_mbs_only_flag=" + this.frame_mbs_only_flag + ", \n        frame_cropping_flag=" + this.frame_cropping_flag + ", \n        frame_crop_left_offset=" + this.frame_crop_left_offset + ", \n        frame_crop_right_offset=" + this.frame_crop_right_offset + ", \n        frame_crop_top_offset=" + this.frame_crop_top_offset + ", \n        frame_crop_bottom_offset=" + this.frame_crop_bottom_offset + ", \n        offsetForRefFrame=" + this.offsetForRefFrame + ", \n        vuiParams=" + this.vuiParams + ", \n        scalingMatrix=" + this.scalingMatrix + ", \n        num_ref_frames_in_pic_order_cnt_cycle=" + this.num_ref_frames_in_pic_order_cnt_cycle + '}';
  }

  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    int i = 1;
    CAVLCWriter localCAVLCWriter = new CAVLCWriter(paramOutputStream);
    localCAVLCWriter.writeNBit(this.profile_idc, 8, "SPS: profile_idc");
    localCAVLCWriter.writeBool(this.constraint_set_0_flag, "SPS: constraint_set_0_flag");
    localCAVLCWriter.writeBool(this.constraint_set_1_flag, "SPS: constraint_set_1_flag");
    localCAVLCWriter.writeBool(this.constraint_set_2_flag, "SPS: constraint_set_2_flag");
    localCAVLCWriter.writeBool(this.constraint_set_3_flag, "SPS: constraint_set_3_flag");
    localCAVLCWriter.writeNBit(0L, 4, "SPS: reserved");
    localCAVLCWriter.writeNBit(this.level_idc, 8, "SPS: level_idc");
    localCAVLCWriter.writeUE(this.seq_parameter_set_id, "SPS: seq_parameter_set_id");
    if ((this.profile_idc == 100) || (this.profile_idc == 110) || (this.profile_idc == 122) || (this.profile_idc == 144))
    {
      localCAVLCWriter.writeUE(this.chroma_format_idc.getId(), "SPS: chroma_format_idc");
      if (this.chroma_format_idc == ChromaFormat.YUV_444)
        localCAVLCWriter.writeBool(this.residual_color_transform_flag, "SPS: residual_color_transform_flag");
      localCAVLCWriter.writeUE(this.bit_depth_luma_minus8, "SPS: ");
      localCAVLCWriter.writeUE(this.bit_depth_chroma_minus8, "SPS: ");
      localCAVLCWriter.writeBool(this.qpprime_y_zero_transform_bypass_flag, "SPS: qpprime_y_zero_transform_bypass_flag");
      int i1;
      if (this.scalingMatrix != null)
      {
        int k = i;
        localCAVLCWriter.writeBool(k, "SPS: ");
        if (this.scalingMatrix == null)
          break label391;
        i1 = 0;
        label237: if (i1 >= 8)
          break label391;
        if (i1 >= 6)
          break label321;
        if (this.scalingMatrix.ScalingList4x4[i1] == null)
          break label315;
      }
      label315: int i5;
      for (int i4 = i; ; i5 = 0)
      {
        localCAVLCWriter.writeBool(i4, "SPS: ");
        if (this.scalingMatrix.ScalingList4x4[i1] != null)
          this.scalingMatrix.ScalingList4x4[i1].write(localCAVLCWriter);
        i1++;
        break label237;
        int m = 0;
        break;
      }
      label321: if (this.scalingMatrix.ScalingList8x8[(i1 - 6)] != null);
      int i3;
      for (int i2 = i; ; i3 = 0)
      {
        localCAVLCWriter.writeBool(i2, "SPS: ");
        if (this.scalingMatrix.ScalingList8x8[(i1 - 6)] == null)
          break;
        this.scalingMatrix.ScalingList8x8[(i1 - 6)].write(localCAVLCWriter);
        break;
      }
    }
    label391: localCAVLCWriter.writeUE(this.log2_max_frame_num_minus4, "SPS: log2_max_frame_num_minus4");
    localCAVLCWriter.writeUE(this.pic_order_cnt_type, "SPS: pic_order_cnt_type");
    if (this.pic_order_cnt_type == 0)
    {
      localCAVLCWriter.writeUE(this.log2_max_pic_order_cnt_lsb_minus4, "SPS: log2_max_pic_order_cnt_lsb_minus4");
      localCAVLCWriter.writeUE(this.num_ref_frames, "SPS: num_ref_frames");
      localCAVLCWriter.writeBool(this.gaps_in_frame_num_value_allowed_flag, "SPS: gaps_in_frame_num_value_allowed_flag");
      localCAVLCWriter.writeUE(this.pic_width_in_mbs_minus1, "SPS: pic_width_in_mbs_minus1");
      localCAVLCWriter.writeUE(this.pic_height_in_map_units_minus1, "SPS: pic_height_in_map_units_minus1");
      localCAVLCWriter.writeBool(this.frame_mbs_only_flag, "SPS: frame_mbs_only_flag");
      if (!this.frame_mbs_only_flag)
        localCAVLCWriter.writeBool(this.mb_adaptive_frame_field_flag, "SPS: mb_adaptive_frame_field_flag");
      localCAVLCWriter.writeBool(this.direct_8x8_inference_flag, "SPS: direct_8x8_inference_flag");
      localCAVLCWriter.writeBool(this.frame_cropping_flag, "SPS: frame_cropping_flag");
      if (this.frame_cropping_flag)
      {
        localCAVLCWriter.writeUE(this.frame_crop_left_offset, "SPS: frame_crop_left_offset");
        localCAVLCWriter.writeUE(this.frame_crop_right_offset, "SPS: frame_crop_right_offset");
        localCAVLCWriter.writeUE(this.frame_crop_top_offset, "SPS: frame_crop_top_offset");
        localCAVLCWriter.writeUE(this.frame_crop_bottom_offset, "SPS: frame_crop_bottom_offset");
      }
      if (this.vuiParams == null)
        break label699;
    }
    while (true)
    {
      localCAVLCWriter.writeBool(i, "SPS: ");
      if (this.vuiParams != null)
        writeVUIParameters(this.vuiParams, localCAVLCWriter);
      localCAVLCWriter.writeTrailingBits();
      return;
      if (this.pic_order_cnt_type != i)
        break;
      localCAVLCWriter.writeBool(this.delta_pic_order_always_zero_flag, "SPS: delta_pic_order_always_zero_flag");
      localCAVLCWriter.writeSE(this.offset_for_non_ref_pic, "SPS: offset_for_non_ref_pic");
      localCAVLCWriter.writeSE(this.offset_for_top_to_bottom_field, "SPS: offset_for_top_to_bottom_field");
      localCAVLCWriter.writeUE(this.offsetForRefFrame.length, "SPS: ");
      for (int n = 0; n < this.offsetForRefFrame.length; n++)
        localCAVLCWriter.writeSE(this.offsetForRefFrame[n], "SPS: ");
      break;
      label699: int j = 0;
    }
  }
}